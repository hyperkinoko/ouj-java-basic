package net.kinokodata.eliza;

import java.util.Date;

public class Eliza {
    public String first() {
        return "私はElizaです。何か話しかけてください。";
    }

    public String talk(String input) {
        int index1 = 0;
        int index2 = 0;

        // 「こんにちは」に反応する
        index1 = input.indexOf("こんにちは");
        if(index1 >= 0) {
            return "こんにちは！好きな食べ物の話でもしませんか？";
        }

        // 「はい」に反応する
        index1 = input.indexOf("はい");
        if(index1 >= 0) {
            return "そうなんですね！他に好きなものはありますか？";
        }

        // 「いいえ」に反応する
        index1 = input.indexOf("いいえ");
        if(index1 >= 0) {
            return "ごめんなさい。間違えました。Elizaの好きな食べ物も聞いてくださいね。";
        }

        // 「私は」と「好き」が含まれている文に反応する
        index1 = input.indexOf("私は");
        index2 = input.indexOf("が好き");

        if(index1 >= 0 && index2 >= 0) {
            String favorite = input.substring(index1+2, index2);
            return "あなたが好きなのは「" + favorite + "」ですか？";
        }

        // 「食べ物」と「好き」が含まれている文に反応する
        index1 = input.indexOf("食べ物");
        index2 = input.indexOf("好き");

        if(index1 >= 0 && index2 >= 0) {
            // 疑似乱数生成
            long timestamp = new Date().getTime();

            switch ((int)timestamp % 3) {
                case 0:
                    return "Elizaは夏みかんが好きです。あなたは何が好きですか？";
                case 1:
                    return "あなたは何が好きですか？";
                default:
                    return "今はおなかいっぱいです。あなたは何が好きですか？";
            }
        }

        return "ごめんなさい。わかりません。好きな食べ物の話でもしませんか？";
    }
}
