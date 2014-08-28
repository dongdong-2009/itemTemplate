package junit;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

import org.junit.Test;

public class ReadDirector {

	@Test
	public void test() {
		try {
			// 读取文件
			List filenames = ReadDirector.getFiles("F:/");
			if (filenames != null)
				for (int i = 0; i < filenames.size() && filenames.size() > 0; i++) {
					String str = (String) filenames.get(i);
					System.out.println("第" + (i < 10 ? "0" + i : i + 1)
							+ "个文件名是：" + str);
				}
		} catch (Exception e) {
		}
	}

	public static List getFiles(String dirname) throws Exception {
		List file_names = null;
		File dir = new File(dirname);
		if (dir.exists()) {
			file_names = new ArrayList();
			File[] files = dir.listFiles();
			// 排序
			Arrays.sort(files, new ReadDirector.CompratorByLastModified());
			for (int i = 0; i < files.length; i++) {
				// 获取文件最后修改时间
				String creatime = ReadDirector.format("yyyy/MM/dd hh:mm:ss",
						new Date(files[i].lastModified()));
				// if(files[i].isHidden()){//判断不是隐藏文件
				// file_names.add("创建时间："+creatime+"<=它是一个隐藏文"+"=>"+files[i].getName());
				// }else if(files[i].isDirectory()){//判断是目录
				// file_names.add("创建时间："+creatime+"<=它是一个文件夹"+"=>"+files[i].getName());
				// }else{//普通文件

				String filename = files[i].getName();

				// 取出后缀名为xls的文件

				//if (filename.matches("^.+\\.xls$"))
					file_names.add(files[i].getName()+", 创建时间：" + creatime);
				// }
			}
		} else {
			System.out.println("该目录没有任何文件信息！");
		}
		return file_names;
	}

	private static String format(String format, Date date) {
		SimpleDateFormat dateFormat = new SimpleDateFormat(format);
		return dateFormat.format(date);
	}

	private static class CompratorByLastModified implements Comparator<File> {
		public int compare(File f1, File f2) {
			long diff = f1.lastModified() - f2.lastModified();
			if (diff > 0)
				return 1;
			else if (diff == 0)
				return 0;
			else
				return -1;
		}

		public boolean equals(Object obj) {
			return true;
		}
	}
}
