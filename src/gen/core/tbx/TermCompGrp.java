//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vJAXB 2.1.10 in JDK 6 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2010.02.18 at 05:48:10 PM EET 
//


package gen.core.tbx;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElements;
import javax.xml.bind.annotation.XmlID;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


/**
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "termComp",
    "termNoteOrTermNoteGrp",
    "adminOrAdminGrpOrTransacGrpOrNoteOrRefOrXref"
})
@XmlRootElement(name = "termCompGrp")
public class TermCompGrp {

    @XmlAttribute
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlID
    protected String id;
    @XmlElement(required = true)
    protected TermComp termComp;
    @XmlElements({
        @XmlElement(name = "termNote", type = TermNote.class),
        @XmlElement(name = "termNoteGrp", type = TermNoteGrp.class)
    })
    protected List<Object> termNoteOrTermNoteGrp;
    @XmlElements({
        @XmlElement(name = "admin", type = Admin.class),
        @XmlElement(name = "adminGrp", type = AdminGrp.class),
        @XmlElement(name = "transacGrp", type = TransacGrp.class),
        @XmlElement(name = "note", type = Note.class),
        @XmlElement(name = "ref", type = Ref.class),
        @XmlElement(name = "xref", type = Xref.class)
    })
    protected List<Object> adminOrAdminGrpOrTransacGrpOrNoteOrRefOrXref;

    /**
     * Gets the value of the id property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getId() {
        return id;
    }

    /**
     * Sets the value of the id property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setId(String value) {
        this.id = value;
    }

    /**
     * Gets the value of the termComp property.
     * 
     * @return
     *     possible object is
     *     {@link TermComp }
     *     
     */
    public TermComp getTermComp() {
        return termComp;
    }

    /**
     * Sets the value of the termComp property.
     * 
     * @param value
     *     allowed object is
     *     {@link TermComp }
     *     
     */
    public void setTermComp(TermComp value) {
        this.termComp = value;
    }

    /**
     * Gets the value of the termNoteOrTermNoteGrp property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the termNoteOrTermNoteGrp property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getTermNoteOrTermNoteGrp().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TermNote }
     * {@link TermNoteGrp }
     * 
     * 
     */
    public List<Object> getTermNoteOrTermNoteGrp() {
        if (termNoteOrTermNoteGrp == null) {
            termNoteOrTermNoteGrp = new ArrayList<Object>();
        }
        return this.termNoteOrTermNoteGrp;
    }

    /**
     * Gets the value of the adminOrAdminGrpOrTransacGrpOrNoteOrRefOrXref property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the adminOrAdminGrpOrTransacGrpOrNoteOrRefOrXref property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAdminOrAdminGrpOrTransacGrpOrNoteOrRefOrXref().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Admin }
     * {@link AdminGrp }
     * {@link TransacGrp }
     * {@link Note }
     * {@link Ref }
     * {@link Xref }
     * 
     * 
     */
    public List<Object> getAdminOrAdminGrpOrTransacGrpOrNoteOrRefOrXref() {
        if (adminOrAdminGrpOrTransacGrpOrNoteOrRefOrXref == null) {
            adminOrAdminGrpOrTransacGrpOrNoteOrRefOrXref = new ArrayList<Object>();
        }
        return this.adminOrAdminGrpOrTransacGrpOrNoteOrRefOrXref;
    }

}