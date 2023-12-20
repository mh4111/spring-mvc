package hello.servlet.basic.request;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

/*
* 1, 파라미터 전송기능
* 2. http://localhost:8080/request-param?username=hello&age=20
* */

@WebServlet(name = "requestParamServlet", urlPatterns = "/request-param")
public class RequestParamServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        System.out.println("[전체 파라미터 조회] - start");

        request.getParameterNames().asIterator()
                        .forEachRemaining(paramName -> System.out.println(paramName + "=" + request.getParameter(paramName)));

        System.out.println("[전체 파라미터 조회] - end");
        System.out.println();

        System.out.println("[단일 파라미터 조회]");
        String username = request.getParameter("username");
        String age = request.getParameter("age");

        System.out.println("username = " + username);
        System.out.println("age = " + age);
        System.out.println();

        System.out.println("[이름이 같은 복수 파라미터 조회]");
        String[] usernames = request.getParameterValues("username");
        for (String name : usernames){
            System.out.println("username = " + name);
        }

        response.getWriter().write("OK");
    }
}

/*
* 1.request.getParameter()는 하나의 파라미터 이름에 대해서 닫 하나의 값만 있을 때 사용
* 2.request.getParameterValues()는 값이 중복일 때 사용
* 3. 참고로 값이 중복일때 .getParameter()를 사용하면 getParameterValues()의 첫번째 값을 반환.
* */