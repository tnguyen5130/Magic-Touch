package Traindata;
import Gameinfo.*;
import java.util.List;
import java.util.ArrayList;

import org.opencv.core.CvType;
import org.opencv.core.Mat;
import org.opencv.core.MatOfPoint;
import org.opencv.core.Point;
import org.opencv.core.Rect;
import org.opencv.core.Scalar;
import org.opencv.core.Size;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;

public class Matrix {
	private static int height = EnumSprite.HEIGHT.getValue();
	private static int width = EnumSprite.WIDTH.getValue();
	private static int size=20;
	public static byte[][] matrix=new byte[height][width];
	public static byte[][] resizedMat=new byte[size][size];
	public static Mat mat1=new Mat(),mat2,mat3=new Mat(),imageHSV,imageBlurr,image;
	public static Rect rect;
	public static List<MatOfPoint> contours;
	public static ArrayList<Rect> allRects;
	public static Size sz=new Size(20,20);
	public static byte[] cell=new byte[3];
	
	public static void setUpMatrix() {
//		for(int i=0;i<height;i++) {
//			for(int j=0;j<width;j++) {
//				matrix[i][j]=0;
//			}
//		}
		contours=new ArrayList<MatOfPoint>();
		allRects=new ArrayList<Rect>();
		
		mat1=Imgcodecs.imread("res/white.png",Imgproc.COLOR_BGR2GRAY);
		mat2=new Mat(mat1.size(), CvType.CV_32F);
		imageHSV = new Mat(mat1.size(), CvType.CV_8UC4);
		imageBlurr = new Mat(mat1.size(),CvType.CV_8UC4);
		
		Imgproc.cvtColor(mat1, imageHSV, Imgproc.COLOR_BGR2GRAY);
		Imgproc.GaussianBlur(imageHSV, imageBlurr, new Size(5,5), 0);
		Imgproc.adaptiveThreshold(imageBlurr, mat2, 255,Imgproc.ADAPTIVE_THRESH_MEAN_C, Imgproc.THRESH_BINARY,7, 5);
		Imgproc.findContours(mat2, contours, new Mat(),Imgproc.RETR_LIST,Imgproc.CHAIN_APPROX_SIMPLE);
		
		for(int i=0;i<contours.size();i++) {
			if(Imgproc.contourArea(contours.get(i))>50) {
				rect = Imgproc.boundingRect(contours.get(i));
				if((rect.height>1 && rect.height<EnumSprite.HEIGHT.getValue())&&(rect.width>1 && rect.width<EnumSprite.WIDTH.getValue())) {
//				if((rect.height>1)&&(rect.width>1)) {
					allRects.add(rect);
				}
			}
		}
		rect=getMaxRect(allRects);
		Imgproc.rectangle(mat1, new Point(rect.x, rect.y),new Point(rect.x+rect.width,rect.y+rect.height),new Scalar(255,255,255));
		image=new Mat(mat1,rect);
		Imgcodecs.imwrite("res/result.png",image);
	}
	
	public static void resizeMatrix() {
//		for(int i=0;i<size;i++) {
//			for(int j=0;j<size;j++) {
//				resizedMat[i][j]=matrix[i*(height/size)][j*(width/size)];
//			}
//		}
		Imgproc.resize(image, mat3, sz);
		Imgcodecs.imwrite("res/resized.png",mat3);
	}
	
	public static void fillOne(int i, int j) {
		for(int m=20;m>-20;m--) {
			for(int n=20;n>-20;n--) {
				matrix[i-m][j-n]=(byte)255;
			}
		}
	}
	
	public static void makeMat() {
//		for (int i = 0; i < size; i++) {
//			for (int j = 0; j < size; j++) {
//				makeCell(resizedMat[i][j]);
//				mat.put(i, j, cell);
//			}
//		}
		Imgproc.cvtColor(mat2, mat2, Imgproc.COLOR_BGR2GRAY);
	}
	
	private void makeCell(byte n) {
		cell[0]=n;
		cell[1]=n;
		cell[2]=n;
	}
	
	private static Rect getMaxRect(ArrayList<Rect> list) {
		if(list.size()==0) {
			return new Rect(0,0,EnumSprite.WIDTH.getValue(),EnumSprite.HEIGHT.getValue());
		}
		Rect maxRect;
		maxRect=list.get(0);
		for(Rect i:list) {
			if(value(maxRect)<value(i)) {
				maxRect=i;
			}
		}
		return maxRect;
	}
	
	private static int value(Rect r) {
		return (r.height*r.width);
	}
}
