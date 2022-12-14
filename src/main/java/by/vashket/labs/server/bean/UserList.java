package by.vashket.labs.server.bean;

import jakarta.xml.bind.annotation.*;
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
public class UserList {
    @XmlElement(name = "user")
    private List<User> users;
    public void addUser(User user) {
        if (users != null) {
            users.add(user);
        } else {
            users = Arrays.asList(user);
        }
    }
}
