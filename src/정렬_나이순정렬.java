import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

class Member implements Comparable<Member> {
	int age = 0;
	String name = "";
	int order = 0;

	public Member(int age, String name, int order) {
		this.age = age;
		this.name = name;
		this.order = order;
	}

	public int getAge() {
		return this.age;
	}

	public String getName() {
		return this.name;
	}

	public int getOrder() {
		return this.order;
	}


	@Override
	public int compareTo(Member o1) {
		return getAge() - o1.age;
	}
}

public class 정렬_나이순정렬 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		ArrayList<Member> list = new ArrayList<Member>();

		int n = Integer.parseInt(st.nextToken());
		for (int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine());
			int age = Integer.parseInt(st.nextToken());
			String name = st.nextToken();
			list.add(new Member(age, name, i));
		}

		Collections.sort(list);

		for (int i = 0; i < list.size(); i++) {
			bw.write(list.get(i).getAge() + " " + list.get(i).getName());
			bw.newLine();
		}
		bw.flush();
		bw.close();
		br.close();
	}
}

/*
 * 4 20 a 20 b 20 aa 20 ab
 * 
 */