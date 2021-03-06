package jae.jjfactory.login.web.login;

import jae.jjfactory.login.domain.login.LoginService;
import jae.jjfactory.login.domain.member.Member;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

@Slf4j
@RequiredArgsConstructor
@Controller
public class LoginController {

    private final LoginService loginService;

    @GetMapping("/login")
    public String loginForm(@ModelAttribute("loginForm") LoginForm form){
        return "/login/loginForm";
    }

//    @PostMapping("/login")
//    public String login(@Valid @ModelAttribute LoginForm form, BindingResult bindingResult, HttpServletResponse response){
//        if (bindingResult.hasErrors()){
//            return "/login/loginForm";
//        }
//        Member loginMember = loginService.login(form.getLoginId(), form.getPassword());
//
//        if(loginMember == null){
//            bindingResult.reject("login failed","아이디 또는 비밀번호가 일치하지 않습니다");
//            return "/login/loginForm";
//        }
//
//        // 로그인 성공
//
//        //쿠키에 시간정보 안주면 세션쿠키. 주면 영속쿠키
//        Cookie idCookie = new Cookie("memberId", String.valueOf(loginMember.getId()));
//        response.addCookie(idCookie);
//
//        return "redirect:/";
//    }

//    @PostMapping("/logout")
//    public String logout(HttpServletResponse response){
//        expireCookie(response,"memberId");
//        return "redirect:/";
//    }

    private void expireCookie(HttpServletResponse response, String cookieName) {
        Cookie cookie = new Cookie(cookieName, null);
        cookie.setMaxAge(0);
        response.addCookie(cookie);
    }
}
