package com.main.nowflix.client.profile.vo;

public class ProfileVO {
   private int profile_id;
   private String email;
   private String profile_name;
   private String kids;
   private String profile_img;
   private String genre_name;

   public ProfileVO() {
      super();
      // TODO Auto-generated constructor stub
   }
   
   

   public ProfileVO(String email, String profile_name, String kids, String profile_img,
         String genre_name) {
      super();
      this.email = email;
      this.profile_name = profile_name;
      this.kids = kids;
      this.profile_img = profile_img;
      this.genre_name = genre_name;
   }



   public int getProfile_id() {
      return profile_id;
   }

   public void setProfile_id(int profile_id) {
      this.profile_id = profile_id;
   }

   public String getEmail() {
      return email;
   }

   public void setEmail(String email) {
      this.email = email;
   }

   public String getProfile_name() {
      return profile_name;
   }

   public void setProfile_name(String profile_name) {
      this.profile_name = profile_name;
   }

   public String getKids() {
      return kids;
   }

   public void setKids(String kids) {
      this.kids = kids;
   }

   public String getProfile_img() {
      return profile_img;
   }

   public void setProfile_img(String profile_img) {
      this.profile_img = profile_img;
   }

   public String getGenre_name() {
      return genre_name;
   }

   public void setGenre_name(String genre_name) {
      this.genre_name = genre_name;
   }

   @Override
   public String toString() {
      return "ProfileVO [profile_id=" + profile_id + ", email=" + email + ", profile_name=" + profile_name + ", kids="
            + kids + ", profile_img=" + profile_img + ", genre_name=" + genre_name + "]";
   }
   
   

}