import java.io.*;
import java.util.*;

public class HashMain {
    public static int eval(SlideShow a, SlideShow b){
        int com;
        int s1;
        int s2;
        Set<String> s11 =new HashSet<>(a.tags);
        Set<String> s22 =new HashSet<>(b.tags);
//        System.out.println();
//        2
//        H 5 a b c d e
//        H 3 a f g
        Set<String> s =new HashSet<>(a.tags);
        s.retainAll(b.tags);
        com=s.size();
//        System.out.println();
//        System.out.print(com +" ");
        s11.removeAll(s22);

        s1=s11.size();
        s11=new HashSet<>(a.tags);
        s22=new HashSet<>(b.tags);
//        System.out.print(s1 +" ");
        s11=new HashSet<>(a.tags);
        s22=new HashSet<>(b.tags);

        s22.removeAll(s11);
        s2=s22.size();
//        System.out.print(s2 +" ");
//        System.out.println();
        return  Math.min(Math.min(s2,s1),com);

    }
    public static void main(String args[]) throws IOException {
        Scanner sn = new Scanner(System.in);
//        String file = "src/test/resources/test_read.txt";
//        Scanner scanner = new Scanner(new File(file));
        int n;
        Map<Integer, Photo> photoMap= new HashMap<>();
//        Map<Integer, SlideShow> showMap= new HashMap<>();
        List<SlideShow> slideShows=new ArrayList<>();
        n=sn.nextInt();
        String s;
        int r;
        String tag;
        for (int i=0; i<n; i++){
            Photo photo=new Photo();
            photo.setID(i);
           s=sn.next();

           if (s.equals("H")){
               photo.setVERTICAL(false);
           }else{
               photo.setVERTICAL(true);
           }
           r=sn.nextInt();
           for (int j=0; j<r;j++){
               tag=sn.next();
               photo.addTag(tag);
           }
           photoMap.put(i,photo);
        }

        List<Photo> ver = new ArrayList<>();
        List<Photo> hor = new ArrayList<>();
        BufferedWriter writer = new BufferedWriter(new FileWriter("C:\\Users\\Nihad Atakishiyev\\IdeaProjects\\untitled7\\auted\\outed.out"));
        for (int i=0; i<photoMap.size();i++){
            Photo tmp = photoMap.get(i);
            SlideShow slideShow=new SlideShow();
            if (tmp.isVERTICAL()){
                ver.add(tmp);
            }else {
                hor.add(tmp);
            }

        }
        int c=ver.size()/2 + hor.size();
        System.out.println(c);
        writer.write(Integer.toString(c));
        writer.write("\n");
        for (int i=0; i<ver.size();i++){
            Photo f= ver.get(i);
            SlideShow slideShow=new SlideShow();
//            System.out.print(f.getID()+" ");
//            writer.write(f.getID()+" ");
            slideShow.photos.add(f);
            i++;
            Photo fc= ver.get(i);
//            System.out.print(fc.getID()+" ");
//            writer.write(fc.getID()+" ");
            slideShow.photos.add(fc);
//            System.out.println();
//            writer.write("\n");
            slideShow.setFullTags();
            slideShows.add(slideShow);
        }
        for (int i=0; i<hor.size();i++){
            Photo f= hor.get(i);
            SlideShow slideShow=new SlideShow();
//            System.out.print(f.getID()+" ");
//            writer.write(f.getID()+" ");
            slideShow.photos.add(f);
//            System.out.println();
//            writer.write("\n");
            slideShow.setFullTags();
            slideShows.add(slideShow);
        }
//        System.out.println(eval(slideShows.get(0),slideShows.get(1)));
        int minnn= 0;
        int aid=0;
        List<SlideShow> dep= new ArrayList<>();
//        System.out.println(slideShows.size());
        List<SlideShow> dep2= new ArrayList<>(slideShows);
        int aa[]=new int[1000];
        for (int i=0; i<slideShows.size(); i++){

            for (int j=0; j<dep2.size(); j++){
                if (dep2.get(j)!=null){
                    int asd= eval(slideShows.get(aid),dep2.get(j));
                    if (asd>=minnn) {
                        minnn=asd;
                        aid=j;
                    }
                }

            }
            dep2.set(0,null);
            minnn=0;
            dep.add(slideShows.get(aid));
            dep2.set(aid,null);

        }

        System.out.println(dep.size());
        for (int i=0; i<dep.size();i++){
            SlideShow sd = dep.get(i);
            for (int j=0; j<sd.photos.size(); j++){
                Photo f= sd.photos.get(j);
                aa[f.getID()]++;
//                System.out.print(f.getID()+" ");
                writer.write(f.getID()+" ");
            }
//            System.out.println();
            writer.write("\n");
        }
        for (int i=0; i<1000;i++){
            if (aa[i]==0){
                System.out.println(i+ "budu blyat");
            }
        }
    writer.close();
    }
}
