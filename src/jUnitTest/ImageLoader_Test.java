package jUnitTest;

import java.awt.Image;

import javax.swing.Icon;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import UtilityClasses.ImageLoader;

public class ImageLoader_Test {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Test
	public void testLoadImage_Success() {
		String imageName = "IngameScreen/ufo_0.png";
		Image image = ImageLoader.Image(imageName);
		Assert.assertNotNull(image);
	}
	
	@Test
	public void testLoadImage_Fail() {
		String imageName = "IngameScreen/ufo_2.png";
		Image image = ImageLoader.Image(imageName);
		Assert.assertNull(image);
	}
	
	@Test
	public void testLoadIcon_Success() {
		String iconName = "IngameScreen/ufo_0.png";
		Icon icon = ImageLoader.loadIcon(iconName);
		Assert.assertNotNull(icon);
	}
	
	@Test
	public void testLoadIcon_Fail() {
		String iconName = "IngameScreen/ufo_2.png";
		Icon icon = ImageLoader.loadIcon(iconName);
		Assert.assertNull(icon);
	}

}
