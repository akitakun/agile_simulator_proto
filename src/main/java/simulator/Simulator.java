package simulator;

public class Simulator {

	//Bugの検出箇所割合
	static double rd_bug = 0;
	static double bd_bug = 0;
	static double dd_bug = 0;
	static double m_bug = 0.6;
	static double it_bug = 0.3;
	static double st_bug = 0.1;

	//修正にかかる期間割合
	static double rd_bugfix = 0;
	static double bd_bugfix = 0;
	static double dd_bugfix = 0;
	static double m_bugfix = 0.44;
	static double it_bugfix = 0.29;
	static double st_bugfix = 0.27;

	//求める開発期間
	double term;

	public double judge(double scale, double bug,double fixTerm) {

		// COCOMO工期による算出期間
		term = 2.4 * Math.cbrt(scale);

		// パラメータのバグの数、１個あたりの修正時間を基に割合をかけて開発工数を求める
		// ※バグの数を開発規模からの割合で求めたほうが規模による差が出て面白いはず
		term = term + ((bug * m_bug) * (fixTerm * m_bugfix) +
				       (bug * it_bug) * (fixTerm * (m_bugfix + it_bugfix)) +
				       (bug * st_bug) * (fixTerm * (m_bugfix + it_bugfix + st_bugfix)))/20;

		return term;

	}

}
