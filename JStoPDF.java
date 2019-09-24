import java.io.File;

public class JStoPDF {
	public static void main(String args[]) {
		String path = "C:\\Users\\H\\Desktop\\siva\\Current Package\\SABBPortal\\src\\main\\webapp\\resources";
		listf(path);
	}

	public static void listf(String directoryName) {
		try {
			File directory = new File(directoryName);
			
			// Get all files from a directory.
			File[] fList = directory.listFiles();
			if (fList != null)
				for (File file : fList) {
					if (file.isFile()) {
						//files.add(file);
						int index = file.getName().lastIndexOf(".");
						String ext = file.getName().substring(index);
						
						if(ext.trim().equals(".js")) {
							String newFileName = file.getName().substring(0, index)+".pdf";
							String filePath = file.getAbsolutePath().replaceAll(file.getName(), "");
							boolean success = file.renameTo(new File(filePath+newFileName));
							if (success) {
							    System.out.println("success");
							}
							else {
								System.out.println("error");
							}
						}
					} else if (file.isDirectory()) {
						System.out.println("\n\n"+file.getAbsolutePath());
						listf(file.getAbsolutePath());
					}
				}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
