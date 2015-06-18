package models;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.Id;
import play.api.mvc.*;
import play.data.validation.Constraints.Required;
import play.db.ebean.Model;
import play.libs.Json;
import com.fasterxml.jackson.databind.JsonNode;
import controllers.*;


@Entity
public class User extends Model {
	@Id
    public Long id;
    @Required
    public String name;
    public Long standid;


    public static Finder<Long,User>find = new Finder(Long.class, User.class);

    public static JsonNode all() {

    List<User> users = find.all();

    return Json.toJson(users);
    }

    public static void create(Forms.newUser newUser) {
    User user = new User();
    user.id = newUser.id;
    user.name = newUser.name;
    user.save();

    }
}




