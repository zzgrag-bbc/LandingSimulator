/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package ch.aplu.jgamegrid;

public enum GGSound {
	DUMMY("wav/_dummy.wav"), FROG("wav/_frog.wav"), CLICK("wav/_click.wav"), FADE("wav/_fade.wav"), NOTIFY(
			"wav/_notify.wav"), EXPLODE("wav/_explode.wav"), MMM(
					"wav/_mmm.wav"), PING("wav/_ping.wav"), BIRD("wav/_bird.wav"), BOING("wav/_boing.wav"), SOUND("wav/_sound.wav");

	private String path;

	private GGSound(String path) {
		this.path = path;
	}

	public String getPath() {
		return this.path;
	}
}