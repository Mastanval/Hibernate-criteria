
package com.klu.Hcql;
public class ClientDemo {
  public static void main(String[] args) {
    Configuration configuration = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Project.class);
    SessionFactory sessionFactory = configuration.buildSessionFactory();
    Session session = sessionFactory.openSession();
    Transaction transaction = session.beginTransaction();

    // Insert Records
    Project p1 = new Project();
    p1.setProjectName("AI Development");
    p1.setDuration(120);
    p1.setBudget(50000);
    p1.setTeamLead("Alice");

    Project p2 = new Project();
    p2.setProjectName("Web App Redesign");
    p2.setDuration(90);
    p2.setBudget(30000);
    p2.setTeamLead("Bob");

    Project p3 = new Project();
    p3.setProjectName("Cloud Migration");
    p3.setDuration(180);
    p3.setBudget(100000);
    p3.setTeamLead("Charlie");

    session.save(p1);
    session.save(p2);
    session.save(p3);

    transaction.commit();

    // Aggregate Functions
    Criteria criteria = session.createCriteria(Project.class);

    // Count
    criteria.setProjection(Projections.rowCount());
    List countResult = criteria.list();
    System.out.println("Total Projects: " + countResult.get(0));

    // Max Budget
    criteria.setProjection(Projections.max("budget"));
    List maxBudget = criteria.list();
    System.out.println("Max Budget: " + maxBudget.get(0));

    // Min Budget
    criteria.setProjection(Projections.min("budget"));
    List minBudget = criteria.list();
    System.out.println("Min Budget: " + minBudget.get(0));

    // Sum Budget
    criteria.setProjection(Projections.sum("budget"));
    List sumBudget = criteria.list();
    System.out.println("Sum Budget: " + sumBudget.get(0));

    // Average Budget
    criteria.setProjection(Projections.avg("budget"));
    List avgBudget = criteria.list();
    System.out.println("Average Budget: " + avgBudget.get(0));

    session.close();
    sessionFactory.close();
  }
}
