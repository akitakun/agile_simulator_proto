package simulator;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigDecimal;

public class Main {

	private static double scale, bug, fixTerm;

	public static void inputParam() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String line;
		scale = 0;			//開発規模（人月ベース）
		bug = 0;			//バグの数
		fixTerm = 0;		//1バグあたりの修正日数
		try {
			System.out.print("scale= ");
			line = br.readLine();
			scale = Integer.parseInt(line);

			System.out.print("bug= ");
			line = br.readLine();
			bug = Integer.parseInt(line);

			System.out.print("fixTerm= ");
			line = br.readLine();
			fixTerm = Integer.parseInt(line);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void showResult(String term) {
		System.out.println("term = "+ term);
	}

	public static void main(String[] args) {
		inputParam();

		Simulator te = new Simulator();
		BigDecimal result = new BigDecimal(te.judge(scale, bug, fixTerm));

		//小数点以下の桁数と、端数処理を指定、文字列に変換
		showResult(result.setScale(1, BigDecimal.ROUND_HALF_UP).toPlainString());
	}


}
