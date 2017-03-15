public class ReplaceBlank {
    public static void main(String[] args) {
        String str = "We are so happy.";
        System.out.println(new ReplaceBlank().replaceSpace(str));

        StringBuffer strBuf = new StringBuffer("We are so happy.");
        System.out.println(new ReplaceBlank().replaceSpace2(strBuf));
    }

    // 方法一，利用字符数组
    public String replaceSpace(String str) {
        char[] charArr = str.toCharArray();
        // 计算源字符串的长度和空格的数量
        int originalLength = charArr.length;
        int numberOfBlank = 0;
        for (char item : charArr)
            if (item == ' ')
                numberOfBlank++;
        // 计算新的字符串长度
        int newLength = originalLength + numberOfBlank * 2;
        char[] newcharArr = new char[newLength];
        //
        int indexOfOriginal = originalLength - 1;
        int indexOfNew = newLength - 1;
        while (indexOfOriginal >= 0) {
            if (charArr[indexOfOriginal] == ' ') {
                newcharArr[indexOfNew--] = '0';
                newcharArr[indexOfNew--] = '2';
                newcharArr[indexOfNew--] = '%';
                indexOfOriginal--;
            } else {
                newcharArr[indexOfNew--] = charArr[indexOfOriginal--];
            }
        }
        return String.valueOf(newcharArr);
    }

    // 方法二，利用 StringBuffer
    public String replaceSpace2(StringBuffer str) {
        String str1 = new String(str);
        return str1.replace(" ", "%20");
    }
}
