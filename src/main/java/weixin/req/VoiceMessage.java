package weixin.req;

public class VoiceMessage {
	// ý��ID  
    private String MediaId;  
    // ������ʽ  
    private String Format;
	public String getMediaId() {
		return MediaId;
	}
	public void setMediaId(String mediaId) {
		MediaId = mediaId;
	}
	public String getFormat() {
		return Format;
	}
	public void setFormat(String format) {
		Format = format;
	}
}
