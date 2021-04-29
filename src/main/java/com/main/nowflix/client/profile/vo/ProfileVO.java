package com.main.nowflix.client.profile.vo;

public class ProfileVO {
   private int profile_id;
   private String email;
   private String profile_name;
   private int horror;
   private int comic;
   private int action;
   
   private int thriller;
   private int sf;
   private int adventure;
   private int drama;
   private int animation;
   private int crime;
   private int familyg;
   private int fantasy;
   private int mystery;
   private int romance;
   private int melodrama;
   private int a_historical_drama;
   
   
   private String kids;
   private String profile_img;
   
   
   public ProfileVO() {
      super();
      // TODO Auto-generated constructor stub
   }
   
   public ProfileVO(String email, String profile_name, int horror, int comic, int action, int thriller,
         int sf, int adventure, int drama, int animation, int crime, int familyg, int fantasy, int mystery,
         int romance, int melodrama, int a_historical_drama, String kids, String profile_img) {
      super();
      this.email = email;
      this.profile_name = profile_name;
      this.horror = horror;
      this.comic = comic;
      this.action = action;
      this.thriller = thriller;
      this.sf = sf;
      this.adventure = adventure;
      this.drama = drama;
      this.animation = animation;
      this.crime = crime;
      this.familyg = familyg;
      this.fantasy = fantasy;
      this.mystery = mystery;
      this.romance = romance;
      this.melodrama = melodrama;
      this.a_historical_drama = a_historical_drama;
      this.kids = kids;
      this.profile_img = profile_img;
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
   public int getHorror() {
      return horror;
   }
   public void setHorror(int horror) {
      this.horror = horror;
   }
   public int getComic() {
      return comic;
   }
   public void setComic(int comic) {
      this.comic = comic;
   }
   public int getAction() {
      return action;
   }
   public void setAction(int action) {
      this.action = action;
   }
   public int getThriller() {
      return thriller;
   }
   public void setThriller(int thriller) {
      this.thriller = thriller;
   }
   public int getSf() {
      return sf;
   }
   public void setSf(int sf) {
      this.sf = sf;
   }
   public int getAdventure() {
      return adventure;
   }
   public void setAdventure(int adventure) {
      this.adventure = adventure;
   }
   public int getDrama() {
      return drama;
   }
   public void setDrama(int drama) {
      this.drama = drama;
   }
   public int getAnimation() {
      return animation;
   }
   public void setAnimation(int animation) {
      this.animation = animation;
   }
   public int getCrime() {
      return crime;
   }
   public void setCrime(int crime) {
      this.crime = crime;
   }
   public int getFamilyg() {
      return familyg;
   }
   public void setFamilyg(int familyg) {
      this.familyg = familyg;
   }
   public int getFantasy() {
      return fantasy;
   }
   public void setFantasy(int fantasy) {
      this.fantasy = fantasy;
   }
   public int getMystery() {
      return mystery;
   }
   public void setMystery(int mystery) {
      this.mystery = mystery;
   }
   public int getRomance() {
      return romance;
   }
   public void setRomance(int romance) {
      this.romance = romance;
   }
   public int getMelodrama() {
      return melodrama;
   }
   public void setMelodrama(int melodrama) {
      this.melodrama = melodrama;
   }
   

   public int getA_historical_drama() {
      return a_historical_drama;
   }

   public void setA_historical_drama(int a_historical_drama) {
      this.a_historical_drama = a_historical_drama;
   }

   @Override
   public String toString() {
      return "ProfileVO [profile_id=" + profile_id + ", email=" + email + ", profile_name=" + profile_name
            + ", horror=" + horror + ", comic=" + comic + ", action=" + action + ", thriller=" + thriller + ", sf="
            + sf + ", adventure=" + adventure + ", drama=" + drama + ", animation=" + animation + ", crime=" + crime
            + ", familyg=" + familyg + ", fantasy=" + fantasy + ", mystery=" + mystery + ", romance=" + romance
            + ", melodrama=" + melodrama + ", a_historycal_drama=" + a_historical_drama + ", kids=" + kids
            + ", profile_img=" + profile_img + "]";
   }
   
   
   
   
}