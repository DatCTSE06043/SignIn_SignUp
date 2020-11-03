package demo.api.untils;

public class StringConstants {

    // Report Chatwork
    private static StringConstants instance;

    public synchronized static StringConstants getInstance() {
        if (instance == null) {
            instance = new StringConstants();
        }
        return instance;
    }

    public static final String API_CHATWORK_BASE_URL = "https://api.chatwork.com";

    public static final String CHATWORK_TOKEN = "33c59ab30cc484ae341a6a6aa15ee5d0";

    public static final String SolutionLogReport_ID = "127315092";

    public String accountNotFound = "Account not found";

    public String accountExits = "ログインIDがすでに登録されました";

    public String accountNull = "Username or password null";

    public String accountNotExitsOrPasswordWrong = "パスワードまたはログインIDが間違いました";

    public String saveTimelineFailure = "Save timeline error";

    public String addPushFailure = "記事配信を登録できませんでした";

    public String check_in_code_not_exits = "無効なQRコードです。";

    public String has_been_check_in_store = "既に友達になっています";
}
