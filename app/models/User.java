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

    public Long stand_id;



    public static Finder<Long,User>find = new Finder(Long.class, User.class);

    public static JsonNode all() {

    List<User> users = find.all();

    return Json.toJson(users);
    }

    /**コントローラ側設定したLong ID,String Nameを引数として、DBに保存する*/
    public static User create(String name,Long id) {
    User user = new User();
    user.name = name ;
    user.stand_id = id ;
    user.save();

    return user;

    }

    /**Json型を戻り値として、DBでstand_idからnameを取り出す*/
    public static JsonNode selectName(Long standid){
    	//System.out.println("yyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyy");
    	//System.out.println(standid);

    	/**一つstand_idに対して複数のnameである、nameを配列として,
    	 * stand_idを使って、DBにnameを検索*/
    	List<User> l = find.where().eq("stand_id",standid).findList();

    	/**Json型を戻る*/
    	return Json.toJson(l);

    }

}
