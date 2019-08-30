package com.hbue.utils;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.imageio.ImageIO;

import org.bytedeco.javacv.FFmpegFrameGrabber;
import org.bytedeco.javacv.Frame;
import org.bytedeco.javacv.Java2DFrameConverter;

public class VideoFrame {
	/**
	 * 获取指定视频的帧并保存为图片至指定目录
	 * 
	 * @param videofile
	 *            源视频文件路径
	 * @param frameFilePath
	 *            截取帧的图片存放路径
	 * @param targerFileName
	 *            截取帧的图片名称
	 * @param imageMat
	 *            图片格式
	 * @throws Exception
	 */
	public static void fetchFrame(String videofile, String frameFilePath,
			String targerFileName,String imageMat) throws Exception {
		long start = System.currentTimeMillis();

		FFmpegFrameGrabber ff = new FFmpegFrameGrabber(videofile);
		ff.start();
		int lenght = ff.getLengthInFrames();
		int i = 0;
		Frame f = null;

		while (i < lenght) {
			// 过滤前50帧，避免出现全黑的图片，依自己情况而定
			f = ff.grabFrame();

			if ((i > 50) && (f.image != null)) {
				break;
			}
			i++;
		}
		Java2DFrameConverter converter = new Java2DFrameConverter();

		String FileName = frameFilePath + File.separator + targerFileName + "." + imageMat;
		BufferedImage bi = converter.getBufferedImage(f);
		File output = new File(FileName);
		try {
			ImageIO.write(bi, imageMat, output);
		} catch (IOException e) {
			e.printStackTrace();
		}
		// ff.flush();
		ff.stop();
		System.out.println(System.currentTimeMillis() - start);
	}

	public static void main(String[] args) throws Exception {
		// randomGrabberFFmpegImage("e:/Java劫匪.mp4", "e:/", "aa", 1);
		fetchFrame("D:/Program Files/grabvieo/testvideo.mp4", "D:/Program Files/grabvieo_img","a1a","jpg");
		System.out.println("adasd");
	}
	
	/**
	 * 
	 * @param filePath 视频路径
	 * @param targerFilePath 抓取视频帧的图片存放路径
	 * @param targetFileName 视频帧的图片名称
	 * @param randomSize 获取视频帧的数量
	 * @throws Exception
	 */
	public static void randomGrabberFFmpegImage(String filePath, String targerFilePath, String targetFileName,
			int randomSize) throws Exception {
		FFmpegFrameGrabber ff = FFmpegFrameGrabber.createDefault(filePath);
		ff.start();
		int ffLength = ff.getLengthInFrames();
		System.out.println(ffLength);
		List<Integer> randomGrab = random(ffLength, randomSize);
		int maxRandomGrab = randomGrab.get(randomGrab.size() - 1);
		Frame f;
		int i = 0;
		while (i < 5) {
			f = ff.grabImage();
			if (randomGrab.contains(i)) {
				doExecuteFrame(f, targerFilePath, targetFileName, i);
			}
			if (i >= maxRandomGrab) {
				break;
			}
			i++;
		}
		ff.stop();
	}

	public static void doExecuteFrame(Frame f, String targerFilePath, String targetFileName, int index) {
		if (null == f || null == f.image) {
			return;
		}

		Java2DFrameConverter converter = new Java2DFrameConverter();

		String imageMat = "jpg";
		String FileName = targerFilePath + File.separator + targetFileName + "_" + index + "." + imageMat;
		BufferedImage bi = converter.getBufferedImage(f);
		File output = new File(FileName);
		try {
			ImageIO.write(bi, imageMat, output);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static List<Integer> random(int baseNum, int length) {

		List<Integer> list = new ArrayList<>(length);
		while (list.size() < length) {
			Integer next = (int) (Math.random() * baseNum);
			if (list.contains(next)) {
				continue;
			}
			list.add(next);
		}
		Collections.sort(list);
		return list;
	}

}
