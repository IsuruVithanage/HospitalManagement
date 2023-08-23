package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Data
public class PatientDTO {

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public void setGardienName(String gardienName) {
        this.gardienName = gardienName;
    }

    public void setGardienContact(String gardienContact) {
        this.gardienContact = gardienContact;
    }

    private String id;
    private String name;
    private String contact;
    private String gardienName;
    private String gardienContact;
}
