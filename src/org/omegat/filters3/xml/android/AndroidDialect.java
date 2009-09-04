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

package org.omegat.filters3.xml.android;

import java.util.regex.Pattern;

import org.omegat.filters3.xml.DefaultXMLDialect;

/**
 * XML dialect declaration for Android filter.
 * 
 * @author Alex Buloichik (alex73mail@gmail.com)
 */
public class AndroidDialect extends DefaultXMLDialect {
    public static final Pattern ROOT_PATTERN = Pattern.compile("resources");

    public AndroidDialect() {
        defineConstraint(CONSTRAINT_ROOT, ROOT_PATTERN);
        defineParagraphTags(new String[] { "string", "item" });
    }
}