//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vJAXB 2.1.10 in JDK 6 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2010.02.22 at 05:32:35 PM EET 
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
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{}termNote"/>
 *         &lt;choice maxOccurs="unbounded" minOccurs="0">
 *           &lt;element ref="{}admin"/>
 *           &lt;element ref="{}adminGrp"/>
 *           &lt;element ref="{}transacGrp"/>
 *           &lt;element ref="{}note"/>
 *           &lt;element ref="{}ref"/>
 *           &lt;element ref="{}xref"/>
 *         &lt;/choice>
 *       &lt;/sequence>
 *       &lt;attribute name="id" type="{http://www.w3.org/2001/XMLSchema}ID" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "termNote",
    "adminOrAdminGrpOrTransacGrp"
})
@XmlRootElement(name = "termNoteGrp")
public class TermNoteGrp {

    @XmlElement(required = true)
    protected TermNote termNote;
    @XmlElements({
        @XmlElement(name = "adminGrp", type = AdminGrp.class),
        @XmlElement(name = "ref", type = Ref.class),
        @XmlElement(name = "admin", type = Admin.class),
        @XmlElement(name = "transacGrp", type = TransacGrp.class),
        @XmlElement(name = "xref", type = Xref.class),
        @XmlElement(name = "note", type = Note.class)
    })
    protected List<Object> adminOrAdminGrpOrTransacGrp;
    @XmlAttribute
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlID
    @XmlSchemaType(name = "ID")
    protected String id;

    /**
     * Gets the value of the termNote property.
     * 
     * @return
     *     possible object is
     *     {@link TermNote }
     *     
     */
    public TermNote getTermNote() {
        return termNote;
    }

    /**
     * Sets the value of the termNote property.
     * 
     * @param value
     *     allowed object is
     *     {@link TermNote }
     *     
     */
    public void setTermNote(TermNote value) {
        this.termNote = value;
    }

    /**
     * Gets the value of the adminOrAdminGrpOrTransacGrp property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the adminOrAdminGrpOrTransacGrp property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAdminOrAdminGrpOrTransacGrp().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link AdminGrp }
     * {@link Ref }
     * {@link Admin }
     * {@link TransacGrp }
     * {@link Xref }
     * {@link Note }
     * 
     * 
     */
    public List<Object> getAdminOrAdminGrpOrTransacGrp() {
        if (adminOrAdminGrpOrTransacGrp == null) {
            adminOrAdminGrpOrTransacGrp = new ArrayList<Object>();
        }
        return this.adminOrAdminGrpOrTransacGrp;
    }

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

}
