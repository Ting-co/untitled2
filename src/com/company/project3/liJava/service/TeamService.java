package com.company.project3.liJava.service;

import com.company.project3.liJava.domain.Architect;
import com.company.project3.liJava.domain.Designer;
import com.company.project3.liJava.domain.Employee;
import com.company.project3.liJava.domain.Programmer;

public class TeamService {
    private static int counter = 1;//给memberid赋值使用
    private static final int MAX_MEMBER = 5;//限制开发团队的人数
    private Programmer[] team = new Programmer[MAX_MEMBER];//保存开发团队成员
    private int total = 0;//开发团队实际人数

    public TeamService() {
    }

    /**
     * 获取开发团队的人
     *
     * @return
     */

    public Programmer[] getTeam() {
        Programmer[] team = new Programmer[total];
        for (int i = 0; i < team.length; i++) {
            team[i] = this.team[i];
        }
        return team;
    }

    public void addMember(Employee e) throws TeamException {
        if (total >= MAX_MEMBER) {
            throw new TeamException("成员已满");
        }

        if (!(e instanceof Programmer)) {
            throw new TeamException("该成员不是开发人员，无法添加");
        }

        if (isExist(e)) {
            throw new TeamException("该成员已经在开发团队中");
        }

        Programmer p = (Programmer) e;
        if ("BUSY".equals(p.getStatus().getNAME())) {
            throw new TeamException("该员工已经是某团队成员");
        } else if ("VOCATION".equals(p.getStatus().getNAME())) {
            throw new TeamException("该员工正在休假，无法添加");
        }

        int numOfArch = 0, numOfDes = 0, numOfPro = 0;
        for (int i = 0; i < total; i++) {
            if (team[i] instanceof Architect) {
                numOfArch++;
            } else if (team[i] instanceof Designer) {
                numOfDes++;
            } else if (team[i] instanceof Programmer) {
                numOfPro++;
            }
        }

        if (p instanceof Architect) {
            if (numOfArch >= 1) {
                throw new TeamException("团队中至多有一名架构师");
            }

        }else if (p instanceof Designer) {
            if (numOfDes >= 2) {
                throw new TeamException("团队中至多有两名设计师");
            }
        }else if (p instanceof Programmer) {
            if (numOfPro >= 3) {
                throw new TeamException("团队中至多有三名序员师");
            }
        }

        team[total++]=p;
        p.setStatus(Status.BUSY);
        p.setMemberId(counter++);

    }

    private boolean isExist(Employee e) {
        for (int i = 0; i < total; i++) {
            if (team[i].getId() == e.getId()) {
                return true;
            }
        }
        return false;
    }
    public void removeMember(int memberId) throws TeamException {
        int i =0;
        for (;i<total;i++){
            if (team[i].getMemberId()==memberId){
                team[i].setStatus(Status.FREE);
                break;
            }
        }
        if (i==total){
            throw new TeamException("找不到指定memberId的员工，删除失败");
        }
        for (int j=i+1;j<total;j++){
            team[j-1]=team[j];
        }
        team[--total]=null;
    }
}