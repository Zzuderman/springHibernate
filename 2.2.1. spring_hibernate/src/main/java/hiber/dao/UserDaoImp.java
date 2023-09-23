package hiber.dao;

import hiber.model.Car;
import hiber.model.User;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class UserDaoImp implements UserDao {

   @Autowired
   private SessionFactory sessionFactory;

   @Override
   public void add(User user, Car car) {
      user.setUserCar(car);
      sessionFactory.getCurrentSession().save(user);
   }


   @Override
   @SuppressWarnings("unchecked")
   public List<User> listUsers() {
      TypedQuery<User> query = sessionFactory.getCurrentSession().createQuery("from User");
      return query.getResultList();
   }

   @Override
   public List<User> listUsersForSeriesAndModelCar(String model,long series) {
      TypedQuery<User> query = sessionFactory.getCurrentSession().createQuery("from User user LEFT OUTER JOIN FETCH user.userCar WHERE user.userCar.series =:series and user.userCar.model =:model ");
      query.setParameter("series", series);
      query.setParameter("model", model);

      return query.getResultList();
   }


}
