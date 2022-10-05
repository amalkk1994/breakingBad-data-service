package com.amc.breakingBad.uploadData.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;

import java.util.ArrayList;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CharactersBB {

    @Id
    private String id;
    private String char_id;
    private String name;
    private String birthday;
    private ArrayList<String> occupation;
    private String img;
    private String status;
    private String nickname;
    private String portrayed;

    @Override
    public String toString() {
        return ("Character:<" + "id:"+ id + "\r\n" + "char_id:" + char_id + "\r\n" +
                "name:" + name + "\r\n" + "birthDay:" + birthday + "\r\n"
                + "occupation:"+ occupation + "\r\n" + "img:" + img + "\r\n" + "status:" + status
        + "\r\n" + "nickName:" + nickname + "\r\n" + "portrayed:" + portrayed+ ">");
    }
}
