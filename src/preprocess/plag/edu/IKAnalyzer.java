package preprocess.plag.edu;

import java.io.IOException;
import java.io.StringReader;

import org.wltea.analyzer.core.IKSegmenter;
import org.wltea.analyzer.cfg.*;
import org.wltea.analyzer.core.Lexeme;
/**
 * 2013.7.25  ����ʹ���ֲ�
 * 1 ����IKAnalyzer2012_u6.jar ,jar �����Ѿ��Դ��ֵ�
 * 2 ��IKAnalyzer.cfg.xml��stopword.dic��������Ŀ��·����
 * 3 �������
 * ò��û��ȥ��ͣ�ô� a
 * ���ܣ�cpu���ɼ��ڴ�ռ�ò���
 * ��һ��������չ�ʿ⡢ͣ�ô�
 * ��IKAnalyzer.cfg.xml��stopword.dic����\binĿ¼��
 * ԭ����Ҫ�����ֵ���ַ���ƥ���дʣ����ܷ�ʽ�Ǿ�ȷ�ִʣ�ȥ�����ֱ�����,Ӣ��ͳһСд
 */
public class IKAnalyzer {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	 Configuration   cfg = DefaultConfig.getInstance();
	 System.out.println("main dic:"+cfg.getMainDictionary());
	 System.out.println("ext dic:"+cfg.getExtDictionarys());
	 System.out.println("stopword dic:"+cfg.getExtStopWordDictionarys());
	 
	 
     IKSegmenter ik = new IKSegmenter(new StringReader("a Hello " +
     		" �л����񹲺͹�      'world java('&quot2013�꣨����,:  19:28 " +
     		"Ansj���ķִ���һ��������ict��ʵ��.���Ҽ������Լ���һЩ���ݽṹ���㷨�ķִ�.ʵ���˸�Ч�ʺ͸�׼ȷ�ʵ��������!" ),true);
     Lexeme le = null;
    
     try {
		while((le=ik.next())!=null){
			 System.out.print(le.getLexemeText()+"|" );
		 }
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
     
     System.out.println(ik.toString());
	}
	public static String segment(String str,boolean bsmart){
		
		return segment(str,bsmart,"");
	}
     public static String segment(String str,boolean bsmart,String split){
       if(str!=null){	 
    	 IKSegmenter ik = new IKSegmenter(new StringReader(str),bsmart);
	     Lexeme le = null;
	     StringBuffer sb = new StringBuffer();
	     try {
			while((le=ik.next())!=null){
				sb.append(le.getLexemeText()+split);
			 }
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	return sb.toString(); 
     }
       return null;
     }
}
