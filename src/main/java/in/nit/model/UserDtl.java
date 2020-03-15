package in.nit.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@NoArgsConstructor
@RequiredArgsConstructor
@Entity
@Table(name = "user_detailstab")
public class UserDtl {
   @Id
   @Column(name = "USR_DET_ID")
   @NonNull
   private Integer id;

   @Column(name = "first_name")
   @NonNull
   private String firstName;

   @Column(name = "last_name")
   @NonNull
   private String lastName;

   @Column(name = "dtlemail")
   @NonNull
   private String email;
   
   @OneToOne(mappedBy="userDtl")
   private User userOb;

   
}