package by.vashket.labs.server.bean;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Arrays;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class DocumentList {
    @XmlElement(name = "document")
    private List<Document> documents;
    public void addUser(Document document) {
        if (documents != null) {
            documents.add(document);
        } else {
            documents = Arrays.asList(document);
        }
    }
}
