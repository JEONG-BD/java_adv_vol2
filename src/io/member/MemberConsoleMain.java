package io.member;

import io.member.impl.DataMemberRepository;
import io.member.impl.FileMemberRepository;
import io.member.impl.MemoryMemberRepository;
import io.member.impl.ObjectMemberRepository;

import java.util.List;
import java.util.Scanner;

public class MemberConsoleMain {

    //private static final MemberRepository repository = new MemoryMemberRepository();
    //private static final MemberRepository repository = new FileMemberRepository();
    //private static final MemberRepository repository = new DataMemberRepository();
    private static final MemberRepository repository = new ObjectMemberRepository();

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        while (true){
            System.out.println("1 회원 등록 | 2 회원 목록 조회 | 3 종료");
            System.out.println("선택");
            int choice = scan.nextInt();
            scan.nextLine();

            switch (choice){
                case 1:
                    registerMember(scan);
                    break;
                case 2:
                    displayMember();
                    break;
                case 3:
                    System.out.println("exit");
                    break;
                default:
                    System.out.println("error");
            }
        }

    }

    private static void registerMember(Scanner scanner){
        System.out.println("ID 입력");
        String id = scanner.nextLine();
        System.out.println("Name 입력");
        String name = scanner.nextLine();
        System.out.println("Age 입력");
        int age = scanner.nextInt();

        Member member = new Member(id, name, age);
        repository.add(member);
    }

    private static void displayMember() {

        List<Member> members = repository.findAll();
        members.stream()
                .forEach(m -> System.out.println(m));
    }
}
