package vrBoard.model.vo;


public class Maplocation implements java.io.Serializable{
   private static final long serialVersionUID =3L;
   
   private int mapnum;
   private String mapname;
   private double mapwi;
   private double mapkung;
   private String imagename;
   private String metro;
   private String gbus;
   private String mbus;
   
   
   public Maplocation() {}


   public String getImagename() {
      return imagename;
   }


   public void setImagename(String imagename) {
      this.imagename = imagename;
   }


   public String getMetro() {
      return metro;
   }


   public void setMetro(String metro) {
      this.metro = metro;
   }


   public String getGbus() {
      return gbus;
   }


   public void setGbus(String gbus) {
      this.gbus = gbus;
   }


   public String getMbus() {
      return mbus;
   }


   public void setMbus(String mbus) {
      this.mbus = mbus;
   }


   public int getMapnum() {
      return mapnum;
   }

   public void setMapnum(int mapnum) {
      this.mapnum = mapnum;
   }


   public String getMapname() {
      return mapname;
   }

   public void setMapname(String mapname) {
      this.mapname = mapname;
   }


   public double getMapwi() {
      return mapwi;
   }


   public void setMapwi(double mapwi) {
      this.mapwi = mapwi;
   }


   public double getMapkung() {
      return mapkung;
   }


   public void setMapkung(double mapkung) {
      this.mapkung = mapkung;
   }


   public static long getSerialversionuid() {
      return serialVersionUID;
   }


   


   public Maplocation(int mapnum, String mapname, double mapwi, double mapkung, String imagename, String metro,
         String gbus, String mbus) {
      super();
      this.mapnum = mapnum;
      this.mapname = mapname;
      this.mapwi = mapwi;
      this.mapkung = mapkung;
      this.imagename = imagename;
      this.metro = metro;
      this.gbus = gbus;
      this.mbus = mbus;
   }


   @Override
   public String toString() {
      return "Maplocation [mapnum=" + mapnum + ", mapname=" + mapname + ", mapwi=" + mapwi + ", mapkung=" + mapkung
            + ", imagename=" + imagename + ", metro=" + metro + ", gbus=" + gbus + ", mbus=" + mbus + "]";
   }

	


}
