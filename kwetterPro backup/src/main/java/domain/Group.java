/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/**
 *
 * @author Jean Paul
 */
@Entity
@Table(name = "HelloGroup")
public class Group {

   
//    @GeneratedValue
//    private Long id;
    @Id
    private String groupName;

    @ManyToMany
    @JoinTable(name="USER_GROUP",
    joinColumns = @JoinColumn(name = "groupName",
    referencedColumnName = "groupName"),
    inverseJoinColumns = @JoinColumn(name = "userName",
    referencedColumnName = "userName"))
    private List<HelloUser> users;

    public Group(){
        
    }
     public Group(String groupName){
        this.groupName = groupName;
    }
    
//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

  
    
}
