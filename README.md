
Bu uygulama, Clean Architecture prensiplerine uygun olarak tasarlanmış bir örnek API uygulamasıdır. Bu yapıda, Retrofit kütüphanesini kullanarak verileri ağ üzerinden alıp listeleme işlemleri gerçekleştirilmiştir. Ayrıca, Hilt kullanarak bağımlılıkları yönetim ve Use Case katmanı aracılığıyla Repository ve ViewModel arasındaki bağlantı sağlanmıştır.

Uygulamanın tasarımı şu şekilde yapılandırılmıştır:

Retrofit: Ağ veri alım işlemlerini yöneten bir API istemcisi olarak kullanılmıştır. Verileri çekmek ve listelemek için gerekli olan HTTP istekleri Retrofit aracılığıyla yapılmaktadır.

Hilt: Bağımlılıkları azaltmak ve yönetmek amacıyla kullanılmıştır. Hilt, DI (Dependency Injection) sağlayarak kodun test edilebilirliğini ve sürdürülebilirliğini artırmaktadır.

Clean Architecture: Uygulama, Clean Architecture prensiplerine uygun olarak katmanlara ayrılmıştır. Bu yaklaşım, uygulamanın her bir bileşeninin (veri, iş mantığı, ve kullanıcı arayüzü) birbirinden bağımsız olarak yönetilmesini sağlar.

Use Case: İş mantığının yönetildiği ve işlevlerin tek bir sorumluluk doğrultusunda düzenlendiği bir katmandır. Repository ve ViewModel arasındaki bağlantıyı sağlayarak kodun modülerliğini ve bakımını kolaylaştırır.

ViewModel: Kullanıcı arayüzü ile iş mantığı arasındaki köprüyü kurar ve kullanıcı etkileşimlerine yanıt verir.

Bu yapı, kodun okunabilirliğini, bakımını ve test edilebilirliğini artırır. Her bir fonksiyon ve sınıf, belirli bir işlevi yerine getirecek şekilde tasarlanmıştır, bu da uygulamanın daha düzenli ve yönetilebilir olmasını sağlar.


![image alt](https://github.com/dumanYusuf/CleanArchitectureRickAndMortyApi/blob/master/clean1.png?raw=true)
![image alt](https://github.com/dumanYusuf/CleanArchitectureRickAndMortyApi/blob/master/clean2.png?raw=true)
![image alt](https://github.com/dumanYusuf/CleanArchitectureRickAndMortyApi/blob/master/clean3.png?raw=true)
