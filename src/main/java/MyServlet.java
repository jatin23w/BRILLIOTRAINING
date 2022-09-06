

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class MyServlet
 */
@WebServlet("/MyServlet")
public class MyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		PrintWriter out = response.getWriter();
		out.println("To see the output please go to the console (Also please hardcode the values in the respective functions to perform the CRUD operations)");
		String action = request.getParameter("action");
		if (action.equals("addEmployee")) {
			try {
				addEmployee();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else if (action.equals("updateEmployee")) {
			try {
				updateEmployee();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else if (action.equals("deleteEmployee")) {
			try {
				deleteEmployee();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else if (action.equals("getEmployeeById")) {
			try {
				getEmployeeById();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else if (action.equals("getAllEmployees")) {
				try {
					getAllEmployees();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	public static void addEmployee() throws Exception {
		CreateConnection createConnection = new CreateConnection();
		Connection con = createConnection.connection();
		PreparedStatement ps = con.prepareStatement("insert into employee values(?,?,?,?,?,?,?)");
		ps.setInt(1, 5);
		ps.setString(2, "Ashish");
		ps.setString(3, "IT");
		ps.setInt(4, 50000);
		ps.setInt(5, 2);
		ps.setString(6, "2018-07-04");
		ps.setInt(7, 1);
		int c = ps.executeUpdate();
		System.out.println(c + "records inserted");
		con.close();
	}

	public static void updateEmployee() throws Exception {
		CreateConnection createConnection = new CreateConnection();
		Connection con = createConnection.connection();
		PreparedStatement ps = con.prepareStatement("update employee set name=? where empId=?");
		ps.setString(1, "Ronaldo");
		ps.setInt(2, 5);
		int c = ps.executeUpdate();
		System.out.println(c + "records updated");
		con.close();
	}

	public static void deleteEmployee() throws Exception {
		CreateConnection createConnection = new CreateConnection();
		Connection con = createConnection.connection();
		PreparedStatement ps = con.prepareStatement("delete from  employee where empId=?");
		ps.setInt(1, 5);
		int c = ps.executeUpdate();
		System.out.println(c + "records deleted");
	}

	public static void getEmployeeById() throws Exception {
		String query = "select * from employee where empId=2";
		CreateConnection createConnection = new CreateConnection();
		Connection con = createConnection.connection();
		Statement st = con.createStatement();

		ResultSet rs = st.executeQuery(query);

		while (rs.next()) {
			System.out.println(rs.getString("name"));
		}
		st.close();

		con.close();
	}

	public static void getAllEmployees() throws Exception {
		String query = "select * from employee";
		CreateConnection createConnection = new CreateConnection();
		Connection con = createConnection.connection();
		Statement st = con.createStatement();

		ResultSet rs = st.executeQuery(query);

		while (rs.next()) {
			System.out.println(rs.getString("name"));
		}
		st.close();

		con.close();

	}

}
