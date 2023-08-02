package io.eunhae.jpa.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@ToString
@Setter
@Getter
@Entity
@Table(name="diary_tb")
public class Diary {

    @Id
    private String id;

    private String location;

    private long registerDate;

    public Diary(String id, String location){
        this.id = id;
        this.location = location;
        this.registerDate = System.currentTimeMillis();
    }

    public static Diary sample(){
        return new Diary("0001", "Masan");
    }
}
