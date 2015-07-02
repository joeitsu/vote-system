package models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import play.api.mvc.*;
import play.data.validation.Constraints.Required;
import com.avaje.ebean.Model;
import play.libs.Json;
import com.fasterxml.jackson.databind.JsonNode;
import controllers.*;

@Entity
public class Stand extends Model {
    @Id
    public Long id;
    @Required
    public String standname;

    public String post;

    public static Finder<Long,Stand>find = new Finder(Long.class, Stand.class);

   /**Json型戻り値、standを配列として、全てを探す*/
    public static JsonNode all() {
        List<Stand> stands = find.all();
        return Json.toJson(stands);
    }

    /**引数はフォーム型のaddData*/
    public static JsonNode create(Forms.StandForm addData) {
        Stand stand = new Stand();
        stand.standname = addData.standname;
        stand.post = addData.post;
        stand.save();

        return Json.toJson(stand);
    }

    /**Long型を戻り値として、standnameを使って、DBからIDを取り出す*/
    public static Long checkId (String standname){


    	//System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
    	//System.out.println(standname);
    	Stand stand = find.where().eq("standname", standname).findUnique();

    	return stand.id;
    }

    }