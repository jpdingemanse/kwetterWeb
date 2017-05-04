/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQuery;

/**
 *
 * @author Jean Paul
 */
@Entity
@NamedQuery(name = "Role.all", query="SELECT r FROM Role r")
public class Role implements Serializable {
    @Id
    private String groupName;
    
    @ManyToMany
    @JoinTable(name="user_group",
    joinColumns = @JoinColumn(name = "groupName",
    referencedColumnName = "groupName"),
    inverseJoinColumns = @JoinColumn(name = "userName",
    referencedColumnName = "userName"))
    private List<User> user_role;

    public Role() {
        
    }
    
    public Role(String right) {
        this.groupName = right;
        this.user_role = new ArrayList<>();
    }
    
    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }
    
    public List<User> getUser_role() {
        return user_role;
    }

    public void setUser_role(List<User> user_role) {
        this.user_role = user_role;
    }
    
}