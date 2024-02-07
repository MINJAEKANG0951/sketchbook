package minjaelab.sketchbook.api_communication.returnShapedModels;

public class ShortURLResponse
{
    private Result result;
    private String message;
    private String code;

    public Result getResult() { return result; }
    public void setResult(Result result) { this.result = result; }
    public String getMessage() { return message; }

    public void setMessage(String message) { this.message = message; }
    public String getCode() { return code; }
    public void setCode(String code) { this.code = code; }

    public class Result {
        private String url;
        private String hash;
        private String orgUrl;

        public String getUrl() { return url; }
        public void setUrl(String url) { this.url = url; }
        public String getHash() { return hash; }

        public void setHash(String hash) { this.hash = hash; }
        public String getOrgUrl() { return orgUrl; }
        public void setOrgUrl(String orgUrl) { this.orgUrl = orgUrl; }
    }
}
