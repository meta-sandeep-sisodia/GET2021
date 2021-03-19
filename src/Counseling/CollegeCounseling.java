package Counseling;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class CollegeCounseling 
{
	private static Course collegeoffer[];
	private static Student students[];
	private static StudentQueue queue;
	private static String studentDetailsPath="D:\\GET2021\\src\\Counseling\\StudentDetails.xlsx";
	private static String programDetailsPath="D:\\GET2021\\src\\Counseling\\ProgramDetails.xlsx";
	private static String resultPath="D:\\GET2021\\src\\Counseling\\result.xlsx";
	
	public static void assignedProgram() throws Exception
	{
		getFromExcelFileProgramDetails();
		getFromExcelFileStudentsDetails();
		
		queue = new StudentQueue(students.length);
		for (int x = 0; x < students.length; x++)
		{
			queue.enQueue(students[x]);
		}
		for (int x = 0; x < queue.getSize(); x++)
		{
			Student student = queue.deQueue();
			int assigned = 0;
			for (int y = 0; y < 5; y++)
			{
				for (int z = 0; z < collegeoffer.length; z++)
				{
					if (student.getPreference(y).equals(
							collegeoffer[z].getName()))
					{
						int capacity = collegeoffer[z].getCapacity();
						if (capacity > 0)
						{
							student.setAssigned(student.getPreference(y));
							collegeoffer[z].setCapacity(capacity--);
							assigned = 1;
							break;
						}
					}
				}
				if (assigned == 1)
				{
					break;
				}
			}
		}
		writeToExcelFileResult();

	}
	
	public static void getFromExcelFileStudentsDetails() throws IOException
	{
		FileInputStream fileinput = new FileInputStream(new File(studentDetailsPath));
		XSSFWorkbook workbook = new XSSFWorkbook(fileinput);
		List<Student> student = new ArrayList<>();
		XSSFSheet sheet = workbook.getSheetAt(0);
		Iterator<Row> itr = sheet.iterator();
		while (itr.hasNext())
		{
			Row row = itr.next();
			int checkpreference = 0;
			String studentname = "";
			Iterator<Cell> celliterator = row.cellIterator();
			String preference[] = new String[5];
			int index = 0;
			while (celliterator.hasNext())
			{
				Cell cell = celliterator.next();
				if (checkpreference == 0)
				{
					studentname = cell.getStringCellValue();
					checkpreference = 1;
				} else
				{
					preference[index++] = cell.getStringCellValue();
				}
			}
			student.add(new Student(studentname, preference));
			students = new Student[student.size()];
			for (int i = 0; i < student.size(); i++)
			{
				students[i] = student.get(i);
			}
		}
		workbook.close();
	}
	
	public static void getFromExcelFileProgramDetails() throws IOException
	{
		FileInputStream fileinput = new FileInputStream(new File(programDetailsPath));
		XSSFWorkbook workbook = new XSSFWorkbook(fileinput);
		XSSFSheet sheet = workbook.getSheetAt(0);
		Iterator<Row> itr = sheet.iterator();
		List<Course> courses = new ArrayList<>();
		while (itr.hasNext())
		{
			Row row = itr.next();
			int capacity = 0, check = 0;
			String program = "";
			Iterator<Cell> celliterator = row.cellIterator();
			while (celliterator.hasNext())
			{
				Cell cell = celliterator.next();
				if (check == 1)
				{
					capacity = (int) cell.getNumericCellValue();
				}
				else
				{
					check = 1;
					program = cell.getStringCellValue();
				}
			}
			courses.add(new Course(program, capacity));
		}
		collegeoffer = new Course[courses.size()];
		for (int i = 0; i < courses.size(); i++)
		{
			collegeoffer[i] = courses.get(i);
		}
		workbook.close();
	}
	
	public static void writeToExcelFileResult() throws Exception
	{
		FileInputStream result_xlsx = new FileInputStream(new File(resultPath));
		XSSFWorkbook workbook = new XSSFWorkbook(result_xlsx);
		XSSFSheet sheet = workbook.getSheetAt(0);
		int rownum = 0;
		for (int i = 0; i < students.length; i++)
		{
			Row row = sheet.createRow(rownum++);
			Cell cell1 = row.createCell(0);
			cell1.setCellValue(students[i].getName());
			Cell cell2 = row.createCell(1);
			cell2.setCellValue(students[i].getAssigned());
			System.out.print(students[i].getName());
			System.out.println("\t"+students[i].getAssigned());
		}

		try
		{
			FileOutputStream output = new FileOutputStream(new File(resultPath));
			workbook.write(output);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		workbook.close();
	}
}
