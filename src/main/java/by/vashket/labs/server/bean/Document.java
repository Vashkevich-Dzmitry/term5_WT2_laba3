package by.vashket.labs.server.bean;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@XmlType(name = "document")
@XmlRootElement
@AllArgsConstructor
@NoArgsConstructor
public class Document {
    private String name;
    private long id;
}
