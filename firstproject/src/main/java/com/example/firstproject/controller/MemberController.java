package com.example.firstproject.controller;

import com.example.firstproject.dto.MemberForm;
import com.example.firstproject.entity.Member;
import com.example.firstproject.repository.MemberRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.Optional;

@Slf4j
@Controller
public class MemberController {

    @Autowired
    private MemberRepository memberRepository;

    @GetMapping("/signup")
    public String signUpPage() {
        return "members/new";
    }

    @PostMapping("/join")
    public String join(MemberForm memberForm) {

        Member member = memberForm.toEntity();

        Member saved = memberRepository.save(member);

        return "redirect:/members/" + saved.getId();
    }

    @GetMapping("/members/{id}")
    public String show(@PathVariable Long id, Model model) {

        Member member = memberRepository.findById(id).orElse(null);

        model.addAttribute("member", member);

        return "members/show";
    }

    @GetMapping("/members")
    public String index(Model model) {

        List<Member> memberList = (List<Member>)memberRepository.findAll();

        model.addAttribute("memberList", memberList);

        return "members/index";
    }

    @GetMapping("/members/{id}/edit")
    public String edit(@PathVariable Long id, Model model) {

        Member memberEntity = memberRepository.findById(id).orElse(null);

        model.addAttribute("member", memberEntity);

        return "/members/edit";
    }

    @PostMapping("/members/update")
    public String update(MemberForm form) {

        Member memberEntity = form.toEntity();

        Member target = memberRepository.findById(memberEntity.getId()).orElse(null);

        if(target != null) {
            memberRepository.save(memberEntity);
        }

        return "redirect:/members/" + memberEntity.getId();
    }

}
