const AudioContext = window.AudioContext || window.webkitAudioContext;
const audioContext = new AudioContext();
let audio;

let imageClass = document.getElementsByClassName('image');

for(let i = 0; i < imageClass.length; i++){
  imageClass[i].onclick = () => {fetchAudio(imageClass[i].dataset.url);};
}

function play(url){
    const bufferSource = audioContext.createBufferSource();
    bufferSource.buffer = audio;
    //bufferSource.connect(audioContext.destination);
    bufferSource.start();
    streamDestination = audioContext.createMediaStreamDestination();
    bufferSource.connect(streamDestination);
    createAndAppendAudioTag(streamDestination);
    /*x.src = url;
    x.controls = true;
    x.autoplay = true;
    document.body.appendChild(x);
    var analyser = audioContext.createAnalyser();
    let source = audioContext.createMediaElementSource(x);
    source.connect(analyser);
    analyser.connect(audioContext.destination);*/
};

function createAndAppendAudioTag(streamDestination){
  let audioTag = new Audio();
  audioTag.controls = true;
  audioTag.autoplay = true;
  document.body.appendChild(audioTag);
  audioTag.srcObject = streamDestination.stream;
}

function fetchAudio(url){
  fetch(url)
      .then(data => data.arrayBuffer())
      .then(buffer => audioContext.decodeAudioData(buffer))
      .then(decodeAudio => {
          audio = decodeAudio;
      }).then(() => {play(url);});
};

function suspendAudio(){
  audioContext.suspend().then(()=>{});
};

function runAudio(){
  audioContext.resume().then(()=>{});
};
