package Traindata;
import Gameinfo.*;
import org.opencv.core.Mat;
import org.opencv.core.MatOfFloat;
import org.opencv.core.Size;
import org.opencv.ml.SVM;
import org.opencv.objdetect.HOGDescriptor;

public class SVMTrainData {
	
	private SVM model=SVM.create();
	private HOGDescriptor hog=new HOGDescriptor(new Size(20,20),new Size(8,8),new Size(4,4),new Size(8,8),9,1,-1,0,0.2,false,64,true);
	private MatOfFloat descriptors=new MatOfFloat();
	private Mat finalDes;
	
	public SVMTrainData() {
		model.load("my_svm.xml");
		model.setGamma(0.5);
		model.setC(12.5);
		model.setKernel(SVM.RBF);
		model.setType(SVM.C_SVC);
	}
	
	public void createHOG(Mat mat) {
		hog.compute(mat, descriptors);
		finalDes=descriptors.reshape(descriptors.cols(),1);
		
		System.out.println(descriptors.toString());
		System.out.println(finalDes.toString());
	}
	
	public int predict() {
		return (int)model.predict(finalDes);
		
	}
	
}
