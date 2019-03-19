/*
 * JBoss, Home of Professional Open   Source
 * Copyright 2013, Red Hat, Inc. and/or  its affiliates, and individual
 * contributors by the @authors tag. See the copyright.txt in the
 * distribution for a full listing of individual contributors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package controller;

import model.Member;
import model.MemberList;
import service.MemberRegistration;
import data.MongoDataStore;
import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
//import javax.enterprise.inject.Produces;
//import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;
//import javax.validation.constraints.NotNull;
//import javax.ws.rs.Produces;
import java.util.logging.Logger;

// The @Model stereotype is a convenience mechanism to make this a request-scoped bean that has an
// EL name
// Read more about the @Model stereotype in this FAQ:
// http://www.cdi-spec.org/faq/#accordion6 bbb
//@RequestScoped
//@Named
@Model
public class MemberController {

    /*  initialise singleton class ready to accept input */
    MemberList ml = MemberList.MemberList();


    private static final Logger mclogger = Logger.getLogger(MemberController.class.getName());


    private FacesContext facesContext;

    private MemberRegistration memberRegistration = new MemberRegistration();

  //  @Produces
    @Named
    private Member newMember;

// initMember function is executed when this class is injected.
   @PostConstruct
    public void initNewMember() {
        newMember = new Member();
    }

    public Member getNewMember() {
        return newMember;
    }


    public Member changeMember(Member member) {
       member.setName("aaa");
       member.setPhoneNumber("211");
       member.setEmail("aaa");
       return member;
    }

    private void getMembers(@org.jetbrains.annotations.NotNull  MemberList memberlist) {
       memberlist.getMembers();
    }

    public void bbwriteToDb() {
        MongoDataStore mds = new MongoDataStore();
        mds.insertMemberRecordsToDb();
    }

    public void bbgetFromDb() {
        MongoDataStore mds = new MongoDataStore();
        mds.getMemberRecordsFromDb();
    }


    public void performRegistration(Member member, MemberList memberlist) throws Exception {
       try {
           mclogger.info("Member controller:performRegistration");
           mclogger.info("Member controller:performRegistration new member before any changes is:" + member.getName());
           mclogger.info("Member controller:performRegistration new member before any changes is:" + member.getId());

           newMember = new Member();
           newMember.setId(member.getId());
           newMember.setName(member.getName());
           newMember.setPhoneNumber(member.getPhoneNumber());
           newMember.setBburlstr(member.getBburlstr());
           newMember.setEmail(member.getEmail());
          // newMember.setId(member.getId());
           mclogger.info("Member controller:performRegistration member before any changes is:" + member.getId());
           mclogger.info("Member controller:performRegistration new member before any changes is:" + newMember.getId());
           newMember.setPhoneNumber(member.getPhoneNumber());

            //    register(newMember,mbrs);
           memberRegistration.register(member,memberlist);
           changeMember(newMember);

       }catch (Exception e) {
           String errorMessage = getRootErrorMessage(e);
           mclogger.info("Exception in register in Member controller");
       //    FacesMessage m = new FacesMessage(FacesMessage.SEVERITY_ERROR, errorMessage, "Registration unsuccessful");
           // facesContext.addMessage(null, m);
       }

    }

/*
    public void register(Member member, List<Member> mbrs) throws Exception {
        try {
             mclogger.info("Member controller:register - Registering");
            mclogger.info("Member controller  newmember is (" + member.getName() + ")");
             memberRegistration.register(member,mbrs);
     //       mclogger.info("Logger Name: "+mclogger.getName());

           // FacesMessage m = new FacesMessage(FacesMessage.SEVERITY_INFO, "Registered!", "Registration successful");
          //  facesContext.addMessage(null, m);
           // initNewMember();
        } catch (Exception e) {
            String errorMessage = getRootErrorMessage(e);
            mclogger.info("Member controller Exception in register");
            FacesMessage m = new FacesMessage(FacesMessage.SEVERITY_ERROR, errorMessage, "Registration unsuccessful");
           // facesContext.addMessage(null, m);
        }
    }
*/
    private String getRootErrorMessage(Exception e) {
        // Default to general error message that registration failed.
        String errorMessage = "Registration failed. See server log for more information";
        if (e == null) {
            // This shouldn't happen, but return the default messages
            return errorMessage;
        }

        // Start with the exception and recurse to find the root cause
        Throwable t = e;
        while (t != null) {
            // Get the message from the Throwable class instance
            errorMessage = t.getLocalizedMessage();
            t = t.getCause();
        }
        // This is the root cause message
        return errorMessage;
    }

}
