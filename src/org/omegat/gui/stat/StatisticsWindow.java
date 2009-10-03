/**************************************************************************
 OmegaT - Computer Assisted Translation (CAT) tool 
          with fuzzy matching, translation memory, keyword search, 
          glossaries, and translation leveraging into updated projects.

 Copyright (C) 2009 Alex Buloichik
               Home page: http://www.omegat.org/
               Support center: http://groups.yahoo.com/group/OmegaT/

 This program is free software; you can redistribute it and/or modify
 it under the terms of the GNU General Public License as published by
 the Free Software Foundation; either version 2 of the License, or
 (at your option) any later version.

 This program is distributed in the hope that it will be useful,
 but WITHOUT ANY WARRANTY; without even the implied warranty of
 MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 GNU General Public License for more details.

 You should have received a copy of the GNU General Public License
 along with this program; if not, write to the Free Software
 Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA  02111-1307  USA
 **************************************************************************/

package org.omegat.gui.stat;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.text.DateFormat;
import java.util.Date;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.BorderFactory;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.KeyStroke;
import javax.swing.SwingUtilities;

import org.omegat.core.Core;
import org.omegat.core.statistics.CalcMatchStatistics;
import org.omegat.core.statistics.CalcStandardStatistics;
import org.omegat.core.statistics.MatchStatisticsInfo;
import org.omegat.core.threads.LongProcessThread;
import org.omegat.util.Log;
import org.omegat.util.OConsts;
import org.omegat.util.OStrings;
import org.omegat.util.gui.DockingUI;

/**
 * Display match statistics window and save data to file.
 * 
 * @author Alex Buloichik (alex73mail@gmail.com)
 */
public class StatisticsWindow extends JDialog implements
        CalcMatchStatistics.Callback, CalcStandardStatistics.Callback {

    public static enum STAT_TYPE {
        STANDARD, MATCHES
    };

    String[] header = new String[] { "",
            OStrings.getString("CT_STATS_Segments"),
            OStrings.getString("CT_STATS_Words"),
            OStrings.getString("CT_STATS_Characters_NOSP"),
            OStrings.getString("CT_STATS_Characters") };

    boolean[] align = new boolean[] { false, true, true, true, true };
    private JProgressBar progressBar;
    private JTextArea output;
    private LongProcessThread thread;

    public StatisticsWindow(STAT_TYPE statType) {
        super(Core.getMainWindow().getApplicationFrame(), true);

        progressBar = new JProgressBar();
        output = new JTextArea();

        switch (statType) {
        case STANDARD:
            setTitle(OStrings.getString("CT_STATSSTANDARD_WindowHeader"));
            thread = new CalcStandardStatistics(this);
            break;
        case MATCHES:
            setTitle(OStrings.getString("CT_STATSMATCH_WindowHeader"));
            thread = new CalcMatchStatistics(this);
            break;
        }

        // Run calculation
        thread.setPriority(Thread.MIN_PRIORITY);
        thread.start();

        // Prepare UI
        setLayout(new BorderLayout());
        JPanel p = new JPanel(new BorderLayout());
        p.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        add(p);

        progressBar.setStringPainted(true);
        p.add(progressBar, BorderLayout.SOUTH);

        output.setEditable(false);
        output.setFont(new Font("Monospaced", Font.PLAIN, Core.getMainWindow()
                .getApplicationFont().getSize()));
        p.add(new JScrollPane(output), BorderLayout.CENTER);

        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        KeyStroke escape = KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0, false);
        Action escapeAction = new AbstractAction() {
            public void actionPerformed(ActionEvent e) {
                thread.fin();
                dispose();
            }
        };
        getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(
                escape, "ESCAPE");
        getRootPane().getActionMap().put("ESCAPE", escapeAction);

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                thread.fin();
            }
        });

        setSize(400, 300);
        DockingUI.displayCentered(this);
    }

    public void showProgress(final int percent) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                progressBar.setValue(percent);
                progressBar.setString(percent + "%");
            }
        });
    }

    public void displayData(final String result) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                progressBar.setValue(100);
                progressBar.setString("");
                output.setText(result);
                output.setCaretPosition(0);
            }
        });
    }

    public void displayData(final MatchStatisticsInfo result) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                progressBar.setValue(100);
                progressBar.setString("");
            }
        });

        final String[][] table = calcTable(result);
        final String data = showTextTable(header, table, align);
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                output.setText(data);
            }
        });
        String fn = Core.getProject().getProjectProperties()
                .getProjectInternal()
                + OConsts.STATS_MATCH_FILENAME;
        try {
            OutputStreamWriter out = new OutputStreamWriter(
                    new FileOutputStream(fn), OConsts.UTF8);
            try {
                out.write(DateFormat.getInstance().format(new Date()) + "\n");
                out.write(data);
                out.flush();
            } finally {
                out.close();
            }
        } catch (Exception ex) {
            Log.log(ex);
        }
    }

    /**
     * Extract result to text table.
     * 
     * @param result
     *            result
     * @return text table
     */
    protected String[][] calcTable(final MatchStatisticsInfo result) {
        String[][] table = new String[7][5];
        // dump result - will be changed for UI
        for (int i = 0; i < result.rows.length; i++) {
            switch (i) {
            case 0:
                table[i][0] = OStrings.getString("CT_STATSMATCH_RowRepetitions");
                break;
            case 1:
                table[i][0] = OStrings.getString("CT_STATSMATCH_RowExactMatch");
                break;
            case 2:
                table[i][0] = OStrings.getString("CT_STATSMATCH_RowMatch95");
                break;
            case 3:
                table[i][0] = OStrings.getString("CT_STATSMATCH_RowMatch85");
                break;
            case 4:
                table[i][0] = OStrings.getString("CT_STATSMATCH_RowMatch75");
                break;
            case 5:
                table[i][0] = OStrings.getString("CT_STATSMATCH_RowMatch50");
                break;
            case 6:
                table[i][0] = OStrings.getString("CT_STATSMATCH_RowNoMatch");
                break;
            }
            table[i][1] = Integer.toString(result.rows[i].segments);
            table[i][2] = Integer.toString(result.rows[i].words);
            table[i][3] = Integer.toString(result.rows[i].charsWithoutSpaces);
            table[i][4] = Integer.toString(result.rows[i].charsWithSpaces);
        }
        return table;
    }

    /**
     * Draw text table with columns align.
     * 
     * @param columnHeaders
     *            column headers
     * @param table
     *            table data
     * @return text
     */
    protected static String showTextTable(String[] columnHeaders,
            String[][] table, boolean[] alignRight) {
        StringBuilder out = new StringBuilder();

        // calculate max column size
        int maxColSize[] = new int[columnHeaders.length];
        for (int c = 0; c < columnHeaders.length; c++) {
            maxColSize[c] = columnHeaders[c].length();
        }
        for (int r = 0; r < table.length; r++) {
            for (int c = 0; c < table[r].length; c++) {
                maxColSize[c] = Math.max(maxColSize[c], table[r][c].length());
            }
        }

        for (int c = 0; c < columnHeaders.length; c++) {
            appendField(out, columnHeaders[c], maxColSize[c], alignRight[c]);
        }
        out.append('\n');
        for (int r = 0; r < table.length; r++) {
            for (int c = 0; c < table[r].length; c++) {
                appendField(out, table[r][c], maxColSize[c], alignRight[c]);
            }
            out.append('\n');
        }
        return out.toString();
    }

    /**
     * Output field with specified length.
     * 
     * @param out
     *            output stream
     * @param data
     *            field data
     * @param colSize
     *            field size
     */
    private static void appendField(StringBuilder out, String data,
            int colSize, boolean alignRight) {
        if (!alignRight) {
            out.append(data);
        }
        for (int i = data.length(); i < colSize; i++) {
            out.append(' ');
        }
        if (alignRight) {
            out.append(data);
        }
        out.append("\t");
    }
}