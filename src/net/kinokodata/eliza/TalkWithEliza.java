package net.kinokodata.eliza;

import javax.swing.*;

public class TalkWithEliza {
    // Elizaのインスタンス
    private final Eliza eliza = new Eliza();
    // TextAreaのログ
    private String log = "";

    public TalkWithEliza() {
        this.pushToLog(eliza.first(), Person.Eliza);
    }

    public static void main(String[] args) {
        TalkWithEliza talkWindow = new TalkWithEliza();
        talkWindow.start();
    }

    /**
     * 会話ウィンドウの表示
     */
    private void start() {
        // Swingウィンドウの作成
        JFrame myFrame = new JFrame("Eliza");
        myFrame.setBounds(100, 100, 640, 480);
        myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // テキスト入力フィールドの作成
        JTextField myTextField = new JTextField();
        myFrame.add(myTextField);
        myTextField.setBounds(10, 10, 500, 50);

        // ボタンの作成
        JButton myButton = new JButton("話す");
        myFrame.add(myButton);
        myButton.setBounds(520, 10, 100, 50);

        // 会話表示用テキストエリアの作成（スクロール可能）
        JTextArea myTextArea = new JTextArea(log);
        JScrollPane myScrollPane = new JScrollPane(myTextArea);
        myScrollPane.setBounds(10, 70, 600, 360);
        myFrame.add(myScrollPane);

        myFrame.setLayout(null);
        myFrame.setVisible(true);

        // 「話す」ボタンをクリックしたときの挙動（ラムダ式使用）
        myButton.addActionListener(e -> {
            String input = myTextField.getText();
            // 何も入力していないときは無視する
            if(!input.equals("")) {
                this.pushToLog(input, Person.You);
                this.pushToLog(eliza.talk(input), Person.Eliza);
                myTextArea.setText(log);
                myTextField.setText("");
            }
        });
    }

    /** ログに入力を追加する
     * @param text : 会話内容
     * @param parson : 誰が話したか（ElizaかYou）
     */
    private void pushToLog(String text, Person parson) {
        log += parson.getName() + ":\t" + text + "\n";
    }

}
