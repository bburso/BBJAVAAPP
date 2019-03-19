/*
 * BB 281118  re named and defined
 * This class manages a list of member objects.  It is used to display the in memory list
 * of members
 * This is a Singleton class to maintain a list of Member objects in memory
 *
 */
package model;
// external libraries
//import javax.enterprise.inject.Model;
import javax.enterprise.inject.Model;
import java.lang.annotation.Annotation.*;
import java.util.List;
import java.util.ArrayList;
import java.util.logging.Logger;
import service.MemberRegistration;

import javax.faces.bean.RequestScoped;
import javax.inject.Named;


//@RequestScoped
//@Named
@Model
public class MemberList {

    /* create singleton */
    // static variable single_instance of type Singleton
    private static MemberList single_instance = null;
    // static method to create the one instance of MemberList class
    public static MemberList MemberList() {
        // To ensure only one instance is created
        if (single_instance == null) {
            single_instance = new MemberList();
        }
        return single_instance;
    }
    /* create the in memory list of members for the instance of this class */
    private static List<Member> members = new ArrayList<Member>();
    /* used when adding new members */
    private static long member_id = 0;
    /* create this class logger */
    private static final Logger mlplogger = Logger.getLogger(MemberRegistration.class.getName());
    /* set members list */
    public void setMembers(List<Member> members) {
        this.members = members;
    }
    /* get members list */
    public List<Member> getMembers() {
        return members;
    }
    /*  adds a member to the members list */
    public void addMember(Member member) {
        mlplogger.info("Member List Producer:addMember");
        member_id++;
        member.setId(member_id);
        mlplogger.info("Member List Producer:addMember size after set members is" + getMembers().size());
        getMembers().add(member);
    }
    /*  deletes a member to the members list */
    public void deleteMember(Member member) {
        mlplogger.info("Member List Producer:addMember");
        mlplogger.info("Member List Producer:addMember size after set members is" + getMembers().size());
        getMembers().remove(member);
    }
    /*  deletes all members from the members list */
    public void deleteAllMembers() {
        /* mlplogger.info("Member List Producer:addMember");  */
        mlplogger.info("Member List Producer:addMember size after set members is" + getMembers().size());

        int mbrsnum =  getMembers().size();

        for(int x=0; x<mbrsnum; x++){
            getMembers().remove(x);
        }

    }
    public void updateMembers(List<Member> mbrs) {
        mlplogger.info("Member List Producer:updateMembers");
        Member m1 = new Member();
        mlplogger.info("Member List Producer:updateMembers members is this big (" + mbrs.size() + ")");
    }
}
