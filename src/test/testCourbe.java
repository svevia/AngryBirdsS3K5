package test;

import static org.junit.Assert.*;

import org.junit.Test;

import angrybirds.AnimationOiseau;
import angrybirds.Courbe;
import angrybirds.HeartCore;

public class testCourbe {

	@Test
	public void testGetY() {
		Courbe c = new Courbe(1,1,1);
		assertEquals(c.getYenX(3),13.0,0);	
	}
	
	@Test
	public void testPositionOiseau(){
		AnimationOiseau a = new AnimationOiseau(3, 1, 1, 1);
		Courbe c = new Courbe(1,1,1);
		assertEquals(c.getYenX(3),a.getY(),0);	
	}
}
