package in.nit.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="userstab")
public class User {
   @Id
   @Column(name="usrid")
   private Integer id;

   @Column(name = "uname")
   private String username;

   @Column(name = "upwd")
   private String password;

   @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
   @JoinColumn(name="USR_DET_ID",unique = true)
   private UserDtl userDtl;

   //Setter and Getter methods
}