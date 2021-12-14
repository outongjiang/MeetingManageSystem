package util_checkCode;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;
import javax.imageio.ImageIO;
import javax.jws.WebService;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/CheckCode")
public class CheckCode extends HttpServlet{
	static String strs[]= {"2","3","4","5","6","7","8","9","a","b","c","d","e","f","g","h","i","j","k","m","n","p","q","r","s","t",
			"u","v","w","s","y","z"};
	public static String code="";
 	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
 		randCode(resp);
	}
	public static void randCode(HttpServletResponse resp) {
	int width=150;
		
		int height=50;
		
		BufferedImage img=new BufferedImage(width, height, BufferedImage.TYPE_INT_BGR);
		
		Graphics g=  img.getGraphics();
				
		g.setColor(Color.yellow);
		
		g.fillRect(0, 0, width, height);
		
		g.setColor(Color.black);
		
		g.setFont(new Font("����",Font.BOLD,30));
		
		Random random = new Random();
		String temp="";
		code="";
		for(int i=1;i<=4;i++) {
			temp=strs[random.nextInt(strs.length)];
			code+=temp;
			g.drawString(temp,25+i*25 ,25 );
		}
		
		g.setColor(Color.green);
		
		for(int i=1;i<=6;i++) {
			g.drawLine(0, random.nextInt(25)+25,random.nextInt(50)+100, random.nextInt(25)+25);	
		}
		
		for(int i=1;i<=6;i++) {
			g.drawLine(random.nextInt(50), random.nextInt(50), random.nextInt(50), random.nextInt(50));	
			
		}
		
		
		
		try {
			ImageIO.write(img, "jpg", resp.getOutputStream());
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	} 
		
	
	
	
}
