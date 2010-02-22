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
    "descripOrDescripGrpOrAdminOrAdminGrpOrTransacGrpOrNoteOrRefOrXref",
    "langSet"
})
@XmlRootElement(name = "termEntry")
public class TermEntry {

    @XmlAttribute
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlID
    protected String id;
    @XmlElements({
        @XmlElement(name = "descrip", type = Descrip.class),
        @XmlElement(name = "descripGrp", type = DescripGrp.class),
        @XmlElement(name = "admin", type = Admin.class),
        @XmlElement(name = "adminGrp", type = AdminGrp.class),
        @XmlElement(name = "transacGrp", type = TransacGrp.class),
        @XmlElement(name = "note", type = Note.class),
        @XmlElement(name = "ref", type = Ref.class),
        @XmlElement(name = "xref", type = Xref.class)
    })
    protected List<Object> descripOrDescripGrpOrAdminOrAdminGrpOrTransacGrpOrNoteOrRefOrXref;
    @XmlElement(required = true)
    protected List<LangSet> langSet;

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
     * Gets the value of the descripOrDescripGrpOrAdminOrAdminGrpOrTransacGrpOrNoteOrRefOrXref property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the descripOrDescripGrpOrAdminOrAdminGrpOrTransacGrpOrNoteOrRefOrXref property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDescripOrDescripGrpOrAdminOrAdminGrpOrTransacGrpOrNoteOrRefOrXref().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Descrip }
     * {@link DescripGrp }
     * {@link Admin }
     * {@link AdminGrp }
     * {@link TransacGrp }
     * {@link Note }
     * {@link Ref }
     * {@link Xref }
     * 
     * 
     */
    public List<Object> getDescripOrDescripGrpOrAdminOrAdminGrpOrTransacGrpOrNoteOrRefOrXref() {
        if (descripOrDescripGrpOrAdminOrAdminGrpOrTransacGrpOrNoteOrRefOrXref == null) {
            descripOrDescripGrpOrAdminOrAdminGrpOrTransacGrpOrNoteOrRefOrXref = new ArrayList<Object>();
        }
        return this.descripOrDescripGrpOrAdminOrAdminGrpOrTransacGrpOrNoteOrRefOrXref;
    }

    /**
     * Gets the value of the langSet property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the langSet property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getLangSet().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link LangSet }
     * 
     * 
     */
    public List<LangSet> getLangSet() {
        if (langSet == null) {
            langSet = new ArrayList<LangSet>();
        }
        return this.langSet;
    }

}