package weixin.resp;

import weixin.obj.Music;

public class MusicMessage extends BaseMessage {
	// ����  
    private Music Music;

	public Music getMusic() {
		return Music;
	}

	public void setMusic(Music music) {
		Music = music;
	} 
}
